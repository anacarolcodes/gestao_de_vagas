package br.com.anacarolina.gestao_vagas.modules.exceptions;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(){
        super("Company not found");
    }

}
