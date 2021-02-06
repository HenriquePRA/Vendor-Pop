# Vendor Pop :books:

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Conteúdo</summary>
  <ul>
    <li>
      <a href="#sobre">Sobre</a>
      <ul>
        <li><a href="#produto">Classe Produto</a></li>
        <li><a href="#cliente">Classe Cliente</a></li>
        <li><a href="#pedido">Classe Pedido (Express e Normal)</a></li>
        <li><a href="#repositorio">Repositorio</a></li>
        <li><a href="#fachada">Fachada</a></li>
        <li><a href="#console">Aplicação Console</a></li>
        <li><a href="#gui">Aplicação Gŕafica Swing</a></li>
      </ul>
    </li>
    <li><a href="#status">Status</a></li>
    <li><a href="#testes">Testes</a></li>
  </ul>
</details>

<a name="sobre"></a>
## Sobre :information_source:
Feito em 2020, como projeto final da disciplina de programação orientada a objetos neste projeto são explorados conceitos
avançados de poo, como herança, polimorfismo, relacionamentos entre objetos (1 para 1, 1 para *, * para *), sobrecarga
de métodos e construtores.

<ul>
  <li>
    <a name="produto"></a>
    <b>Produto:</b> guarda os campos id, nome, preço e pedidos (arraylist com os pedidos que tem esse produto), possui getters
    para todos os campos todavia setters apenas para nomes e preço. dispõe metodos específicos para adicionar ou
    remover pedidos a sua lista de pedidos.
  </li>
  <br/>
  <li>
    <a name="cliente"></a>
    <b>Cliente:</b> guarda os campos, telefone (id), nome, endereço e pedidos (arraylist com os pedidos associados ao cliente),
    possui getters para todos os seus campos todavia setters apenas para os campos telefone, nome e endereço e dispõe de métodos
    específicos para adicionar ou remover pedidos a sua lista de pedidos. 
  </li>
  <br/>
  <li>
    <a name="pedido"></a>
    <b>Pedido:</b> guarda os campos, id (auto incrementado), datahora, valortotal (soma do valor de todos os produtos + entrega),
    entregador, pago (chave booleana), cliente (objeto cliente), produtos (arraylist com os produtos do pedido).
  </li>
  <br/>
  <li>
    <b>Pedido Express:</b> especialização de pedido que herda todas os atributos e métodos do mesmo, o pedido express possui um
    atributo taxa entrega assim como getter e setter para essa taxa. 
  </li>
  <br/>
  <li>
    <a name="repositorio"></a>
    <b>Repositório:</b> guarda arraylists para objetos do tipo produto, cliente e pedido. possui métodos para adicionar e buscar 
    objetos as listas de cliente, produto, e pedido. também possui 3 métodos get onde cada um retorna uma das listas de objeto e 
    por fim um método para cancelar pedidos.
  </li>
  <br/>
  <li>
    <a name="fachada"></a>
    <b>Fachada:</b> é responsável por criar e realizar a comunicação entre as aplicações (console e gráfica) com o repositório,
    a fachada realiza testes sobre o que deseja-se adicionar ao repositório assim como para remover, levanta exceção caso os 
    requisitos desses testes não sejam satisfeitos. possui métodos que listam clientes produtos e pedidos com filtros específicos,
    métodos para alterar o estado de um pedido adicionando e removendo produtos e tornando-o pago.    
  </li>
  <br/>
  <li>
    <a name="console"></a>
    <b>Aplicação Console:</b> é responsável por criar a fachada e realizar os testes necessários a fim de captar exceções antes
    imprevistas, a aplicação console não interage com o usuário apesar de poder ser executada independentemente da aplicação gráfica.
  </li>
  <br/>
  <li>
    <a name="gui"></a>
    <b>Aplicação Gráfica Swing</b> é por onde o usuário interage com o sistema dispoe de cinco telas principal, criação de pedido,
    alteração de pedido, pagamento de pedido, cancelamento de pedido e listagem. todas as telas são acessadas a partir da tela 
    principal, todas as telas que requerem interação com o usuário possuem label para display de exceções.
  </li>
</ul>

<a name="status"></a>
## Status do Projeto :construction_worker:
  Finalizado :tada:

<a name="testes"></a>
## Testes :computer:

Para visualizar o projeto em execução basta possuir o Java Runtime Enviroment a partir da versão 8, e executar a tela principal
ou aplicação console.
