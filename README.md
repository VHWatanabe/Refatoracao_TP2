# Refatoração de Código: The Parrot Project

## Descrição do Projeto Original
O projeto original simula o comportamento de diferentes tipos de papagaios ('Parrot'), com foco em duas funcionalidades principais:

- **Cálculo de velocidade de voo** ('getSpeed')
- **Som emitido pelo papagaio** ('getCry')

Os tipos de papagaio disponíveis são:

- **European Parrot**
- **African Parrot** (sensível à quantidade de cocos que carrega)
- **Norwegian Blue Parrot** (pode estar "pregado" e ser afetado por voltagem)

A classe 'Parrot' era monolítica, contendo toda a lógica para todos os tipos de papagaios dentro de uma única estrutura, o que dificultava a manutenção, testes e extensibilidade.

---

## Melhorias Realizadas

### Uso de Polimorfismo e Interface:
- Cada tipo de papagaio implementa sua própria lógica de forma independente, aderindo ao princípio OCP (Open/Closed). A classe Parrot apenas delega o comportamento.

### Enum ParrotTypeEnum:
- Substitui o uso de strings para representar tipos, evitando erros e tornando o código mais seguro e legível em tempo de compilação.

### Builder Pattern:
- Facilita a criação de objetos complexos com parâmetros opcionais (voltage, isNailed, etc.), promovendo clareza e evitando construtores com múltiplos parâmetros difíceis de manter.

### Isolamento de Comportamentos:
- Cada classe (EuropeanParrotBehavior, AfricanParrotBehavior, etc.) encapsula seu comportamento específico, promovendo alta coesão e aderência ao SRP (Single Responsibility).

### Extensibilidade:
- A adição de um novo tipo de papagaio requer apenas a criação de uma nova classe que implemente ParrotBehavior, sem necessidade de modificar código existente.

### Cobertura de Testes Ampla:
- Os testes foram reorganizados para validar individualmente os comportamentos de cada tipo de papagaio em diferentes cenários, inclusive casos extremos e inválidos.
