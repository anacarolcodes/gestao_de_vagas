Docker / Postgres - instruções rápidas

Siga estes passos no PowerShell (abra como Administrador quando indicado):

1) Finalizar WSL e reiniciar Docker Desktop

```powershell
wsl --shutdown
# Abra o Docker Desktop (aguarde "Docker is running")
```

2) Limpar imagem possivelmente corrompida e puxar a imagem novamente

```powershell
# listar imagens postgres (opcional)
docker image ls --filter=reference=postgres*

# remover a imagem postgres:15 se existir
docker image rm -f postgres:15

# puxar a imagem novamente
docker pull postgres:15
```

3) Subir a stack com o `docker-compose.yml` do projeto

```powershell
cd "C:\Users\Ana Carolina\VsCodeProjects\gestao_vagas"
# usar o compose integrado (recomendado)
docker compose up -d

# verificar status
docker compose ps
docker compose logs -f postgres
```

4) Caso o pull falhe com erro de JSON ou tempo esgotado

- Reinicie o Docker Desktop e o Windows, tente novamente.
- Verifique configuração de proxy em Docker Desktop → Settings → Resources → Proxies.
- Rode `docker system prune -a --volumes` para limpar cache (cuidado: remove imagens/containers/parados).

5) Se tudo subir com sucesso, a aplicação pode conectar em:

```
jdbc:postgresql://localhost:5432/gestao_vagas
user: admin
password: admin
```

Se quiser eu colo um script PowerShell que automatiza as etapas (remoção da imagem, pull e `docker compose up -d`).