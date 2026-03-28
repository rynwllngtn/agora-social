# Changelog

Todas as mudanças notáveis na API do **Agora System** serão documentadas neste arquivo.

O formato é baseado no [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/).

---

## [Unreleased]

### Added
- Implementação do endpoint *POST*
- Implementação do endpoint *GET /users/{id}*.
- Implementação do endpoint *GET /users*.
- Implementação do serviço *findAll*.
- Criação do `DatabaseSeeder` para popular o banco de dados com 50 usuários de teste na primeira inicialização.
- Criação da entidade `User`, com classes `repository`, `service` e `controller` respectivas.

### Changed
- Alterado o formato do id UUID para String, usando o construtor ObjectId do MongoDB como padrão.

### Fixed
- Correção no mapeamento das propriedades do `application.yaml` para garantir a conexão e representação UUID correta.