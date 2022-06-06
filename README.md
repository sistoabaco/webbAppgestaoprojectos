# sistemadegestaocaritaspemba
Para correr o projecto (maven com java) na maquina local:
1. configurar a sua maquina para que seja capaz de correr um projecto em java;
2. precisar ter uma IDE instalada na sua maquina local;
3. instalar nodejs, yarn, nuxtjs e vuejs para correr frontend

Regras do Negocio:
1. Criar uma solicitacao de transporte (ST) - tecnicos ou coordenador;
2. Criar Termo de referencia(TdR) atraves da ST - Tecnicos no geral;
3. Aprovacao da ST e TdR - Coordenador e Logistico;
4. Criar requisicao de pagamento (RP) e anexar  facturas - logistico;
5. Aprovacao (coordenador, contabilista, financas e direcao);
6. criar ordem de compra (OC) - logistico
7. aprovacao (administracao e financas)
8. Emissao de cheque segundo a TdR - tesouraria;
9. Anexar copia de canhoto e serie do cheque no processo - tesouraria;
10. Arquivar o processo - Contabilidade.

Requisitos do Sistema:
1. pagina principal
2. login
3. pagina de trabalho (links de acordo com permissoes)