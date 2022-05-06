# Api Spring

## 🚀 Começando

### 📋 Pré-requisitos

É necessario ter o docker e docker-composer instalado na maquina,
primeiro passo é gerar a build do projeto java

    gradlew clean build jar -x test
    
assim que a build for concluida executar o docker-compose

    docker-compose up

assim que terminar de baixar todas as imagens e finalizar a inicialização do banco de dados e da api,
basta usar o arquivo postman -> API requests.postman_collection.json na raiz do projeto, que contem todas as requisições da api;

### 🔧 Depois de completar estes passos é só consumir a api com o postman