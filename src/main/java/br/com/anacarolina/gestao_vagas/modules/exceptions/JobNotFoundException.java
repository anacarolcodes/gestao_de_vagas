package br.com.anacarolina.gestao_vagas.modules.exceptions;

public class JobNotFoundException extends RuntimeException{

    public JobNotFoundException(){
        super("Job not found");
    }
}
