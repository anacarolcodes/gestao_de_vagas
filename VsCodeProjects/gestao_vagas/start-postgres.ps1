<#
Simple helper to remove corrupted postgres image, pull again and start compose stack.
Run from project root in PowerShell. Requires Docker Desktop running.
#>

try {
    docker info > $null 2>&1
} catch {
    Write-Host "Docker daemon not available. Start Docker Desktop and try again." -ForegroundColor Red
    exit 1
}

Write-Host "Removing postgres:15 image if present..."
$images = docker image ls --filter=reference=postgres* --format "{{.Repository}}:{{.Tag}}"
foreach ($img in $images) {
    if ($img -ne "") { docker image rm -f $img | Out-Null }
}

Write-Host "Pulling postgres:15..."
if (-not (docker pull postgres:15)) {
    Write-Host "docker pull failed. Check network or Docker logs." -ForegroundColor Red
    exit 1
}

Write-Host "Bringing up stack..."
if (-not (docker compose up -d)) {
    Write-Host "docker compose up failed." -ForegroundColor Red
    exit 1
}

Write-Host "Stack started. Run 'docker compose ps' and 'docker compose logs -f postgres' to follow logs." -ForegroundColor Green
