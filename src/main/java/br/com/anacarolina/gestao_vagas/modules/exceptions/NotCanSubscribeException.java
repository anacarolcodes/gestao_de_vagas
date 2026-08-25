package br.com.anacarolina.gestao_vagas.modules.exceptions;

public class NotCanSubscribeException extends RuntimeException{
    public NotCanSubscribeException(){
        super("Usuário ou Vaga não existem, tente novamente");
    }
}
