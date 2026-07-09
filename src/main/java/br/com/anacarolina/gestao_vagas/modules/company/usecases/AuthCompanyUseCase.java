package br.com.anacarolina.gestao_vagas.modules.company.usecases;

import br.com.anacarolina.gestao_vagas.modules.company.dto.AuthCompanyResponseDTO;
import br.com.anacarolina.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.anacarolina.gestao_vagas.modules.company.repository.CompanyRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;


@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCompanyResponseDTO execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        System.out.println("DEBUG DTO: " + authCompanyDTO.getUsername()); // Adicione isso
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Username/password incorrect");
        });

//verificar se a senha é igual a do banco de dados, usando o passwordEncoder.matches
        //se nao for igual -> retorna erro
        // se for igual -> Gerar token
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if (!passwordMatches) {
            throw new UsernameNotFoundException("Company not found");
        }

        // Se for igual -> Gerar token
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var expiresIN = Instant.now().plus(Duration.ofHours(2));

        var token = JWT.create().withIssuer("javagas")
                .withExpiresAt(expiresIN)
                .withClaim("roles", Arrays.asList("COMPANY"))
                .withSubject(company.getId().toString())
                .sign(algorithm);

        var authCompanyResponseDTO = AuthCompanyResponseDTO.builder()
                .accessToken(token)
                .expires_in(expiresIN.toEpochMilli())
                .build();
        return authCompanyResponseDTO;
    }
}