"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var modoCriacao = false;
var modoPessoa = false;
/*Configuração dos botões e elementos do HTML*/
var buttonExbicao = document.getElementById('buttonExibicao');
var display = document.getElementById('displayContainer');
var criacaoFormulario = document.getElementById('cricaoFormulario');
/*Criando e */
var cadForm = document.getElementById('itemForm');
cadForm.addEventListener("submit", function (e) {
    e.preventDefault();
    //nao esta dando para adicionar o value direto no getElementById *-*
    var nomePessoa = document.getElementById("nomeEmpresa");
    var emailPessoa = document.getElementById("emailEmpresa");
    var idEmpresa = document.getElementById("idEmpresa");
    var descricaoEmpresa = document.getElementById("descricaoEmpresa");
    var estadoEmpresa = document.getElementById("estadoEmpresa");
    var nome = nomePessoa.value;
    var email = emailPessoa.value;
    var id = idEmpresa.value;
    var descricao = descricaoEmpresa.value;
    var estado = estadoEmpresa.value;
    var empresas = [];
    if (localStorage.hasOwnProperty("empresas")) {
        empresas = JSON.parse(localStorage.getItem("empresas") || "[]");
    }
    empresas.push({ nome: nome, email: email, id: id, descricao: descricao, estado: estado });
    localStorage.setItem("empresas", JSON.stringify(empresas));
    nomePessoa.value = "";
    emailPessoa.value = "";
    idEmpresa.value = "";
    descricaoEmpresa.value = "";
    estadoEmpresa.value = "";
});
/*Adicionando funcionalidade as classes {Empresa}/{Usuario}*/
/*Alterando a exibicao de exibir para criar e criar para exibir*/
function mundandoExibicao() {
    if (!buttonExbicao || !display || !criacaoFormulario) {
        return;
    }
    modoCriacao = !modoCriacao;
    if (modoCriacao) {
        buttonExbicao.textContent = 'Exibir';
        display.style.display = 'none';
        criacaoFormulario.style.display = 'block';
    }
    else {
        buttonExbicao.textContent = 'Criar';
        display.style.display = 'block';
        criacaoFormulario.style.display = 'none';
        carregarLista();
    }
}
/*Iniciando as aplicacoes para o funcionamento do codigo*/
function iniciandoAplicacao() {
    buttonExbicao.addEventListener('click', mundandoExibicao);
    var botaoCancelar = document.getElementById('cancelar');
    if (botaoCancelar) {
        botaoCancelar.addEventListener('click', function () {
            if (modoCriacao) {
                mundandoExibicao();
            }
        });
    }
    carregarLista();
}
/*Carregar lista de usuvarios kkkk*/
function carregarLista() {
    var empresas = JSON.parse(localStorage.getItem("empresas") || "[]");
    var listaElement = document.getElementById("lista");
    if (listaElement) {
        listaElement.innerHTML = '';
        var novoItem = document.createElement("li");
        novoItem.textContent = "Teste de item";
        listaElement.appendChild(novoItem);
    }
}
document.addEventListener('DOMContentLoaded', iniciandoAplicacao);
