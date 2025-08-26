"use strict";
//import {Empresa} from './empresa';
//import Chart from "chart.js";
//import {Pessoa} from './pessoa';
let modoCriacao = false;
let modoPessoa = false;
/*Configuração dos botões e elementos do HTML*/
const buttonExbicao = document.getElementById('buttonExibicao') || null;
const display = document.getElementById('displayContainer') || null;
const criacaoFormulario = document.getElementById('cricaoFormulario') || null;
const buttonPessoa = document.getElementById('buttonPessoa') || null;
const buttonGrafico = document.getElementById('buttonGrafico') || null;
const displayGrafico = document.getElementById('criacaoGrafico') || null;
/*Criando e salvando o form*/
const cadForm = document.getElementById('itemForm') || null;
cadForm.addEventListener("submit", (e) => {
    e.preventDefault();
    //nao esta dando para adicionar o value direto no getElementById *-*
    const nomePessoa = document.getElementById("nomeEmpresa");
    const emailPessoa = document.getElementById("emailEmpresa");
    const idEmpresa = document.getElementById("idEmpresa");
    const descricaoEmpresa = document.getElementById("descricaoEmpresa");
    const estadoEmpresa = document.getElementById("estadoEmpresa");
    const competencias = document.querySelectorAll('input[type="checkbox"]');
    const paisEmpresa = document.getElementById("paisEmpresa");
    const cepEmpresa = document.getElementById("cepEmpresa");
    let values = [];
    competencias.forEach(checkbox => {
        if (checkbox.checked) {
            values.push(checkbox.value);
        }
    });
    const nome = nomePessoa.value;
    const email = emailPessoa.value;
    const id = idEmpresa.value;
    const pais = paisEmpresa.value || "BRASIL";
    const cep = cepEmpresa.value;
    const descricao = descricaoEmpresa.value;
    const estado = estadoEmpresa.value;
    const checkCompetencias = values;
    let empresas = [];
    let usuarios = [];
    const tipo = modoPessoa ? "usuário" : "empresa";
    const adicionarEmpresaUsuario = document.getElementById("adicionarEmpresaUsuario");
    if (adicionarEmpresaUsuario) {
        adicionarEmpresaUsuario.textContent = `Adicionar ${tipo}`;
    }
    if (modoPessoa) {
        //const empresa = new Empresa(nome, email, pais, id, estado, cep, descricao, checkCompetencias);
        if (localStorage.hasOwnProperty("usuarios")) {
            usuarios = JSON.parse(localStorage.getItem("usuarios") || "[]");
        }
        else {
            usuarios = [];
        }
        if (!modoPessoa)
            return;
        usuarios.push({ nome, email, id, descricao, estado, checkCompetencias, pais, cep });
        localStorage.setItem("usuarios", JSON.stringify(usuarios));
    }
    else {
        if (localStorage.hasOwnProperty("empresas")) {
            empresas = JSON.parse(localStorage.getItem("empresas") || "[]");
        }
        else {
            empresas = [];
        }
        if (modoPessoa)
            return;
        empresas.push({ nome, email, id, descricao, estado, checkCompetencias, pais, cep });
        localStorage.setItem("empresas", JSON.stringify(empresas));
    }
    nomePessoa.value = "";
    emailPessoa.value = "";
    idEmpresa.value = "";
    descricaoEmpresa.value = "";
    estadoEmpresa.value = "";
    values = [];
    paisEmpresa.value = "";
    cepEmpresa.value = "";
    cadForm.reset();
});
/*Adicionando funcionalidade as classes {Empresa}/{Usuario}*/
function mudandoPessoa() {
    if (!buttonPessoa || !display || !criacaoFormulario) {
        return;
    }
    modoPessoa = !modoPessoa;
    if (modoPessoa) {
        buttonPessoa.textContent = 'Usuario'; //false
        carregarLista();
    }
    else {
        buttonPessoa.textContent = 'Empresa'; //true
        carregarLista();
    }
} // FINALIZADO!!
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
        displayGrafico.style.display = 'none';
    }
    else {
        buttonExbicao.textContent = 'Criar';
        display.style.display = 'block';
        criacaoFormulario.style.display = 'none';
        displayGrafico.style.display = 'none';
        carregarLista();
    }
} //FINALIZADO!!
/*Carregar lista de usuvarios kkkk*/
function carregarLista() {
    const efeitoMatch = true;
    const empresas = JSON.parse(localStorage.getItem("empresas") || "[]");
    const usuarios = JSON.parse(localStorage.getItem("usuarios") || "[]");
    const listaElement = document.getElementById("lista");
    if (listaElement) {
        listaElement.innerHTML = '';
        const itens = modoPessoa ? usuarios : empresas;
        const tipo = modoPessoa ? 'Usuario' : 'Empresa';
        itens.forEach((item) => {
            const novoItem = document.createElement("li");
            novoItem.className = "item";
            let itemMatch;
            if (efeitoMatch) { //Para testar o efeito de match é só colocar !efeitoMatch
                itemMatch = "***********";
            }
            else {
                itemMatch = item.nome;
            }
            novoItem.innerHTML = `<li>${tipo}: ${itemMatch}</br> Email: ${item.email}</br> ID: ${item.id}</br>Localização: ${item.estado}, ${item.pais}  CEP: ${item.cep}</br>Competencias: ${item.checkCompetencias}</br> Descrição: ${item.descricao}</li>`;
            listaElement.appendChild(novoItem);
        });
    }
}
/*Mudando para o grafio*/
function mudandoGrafico() {
    // Primeiro, mostra o container do gráfico
    const usuarios = JSON.parse(localStorage.getItem("usuarios") || "[]");
    const containerGrafico = document.getElementById('criacaoGrafico');
    if (!containerGrafico) {
        console.error('Container do gráfico não encontrado!');
        return;
    }
    containerGrafico.style.display = 'block';
    // Esconde outros elementos
    const display = document.getElementById('displayContainer');
    const criacaoFormulario = document.getElementById('cricaoFormulario');
    if (display)
        display.style.display = 'none';
    if (criacaoFormulario)
        criacaoFormulario.style.display = 'none';
    // Agora busca o canvas
    const canvas = document.getElementById('grafico');
    if (!canvas) {
        console.error('Elemento canvas não encontrado!');
        return;
    }
    // Verifica se o Chart está disponível
    if (typeof Chart === 'undefined') {
        console.error('Chart.js não foi carregado corretamente!');
        return;
    }
    const competenciaUsuario = usuarios.flatMap((usuario) => Array.from(usuario.checkCompetencias));
    const contagemCompetencias = competenciaUsuario.reduce((acc, competencia) => {
        acc[competencia] = (acc[competencia] || 0) + 1;
        return acc;
    }, {});
    const labels = Object.keys(contagemCompetencias);
    const dados = Object.values(contagemCompetencias);
    // Cria o gráfico
    return new Chart(canvas, {
        type: 'polarArea',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Usuários',
                    data: dados,
                    borderWidth: 2,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.7)',
                        'rgba(54, 162, 235, 0.7)',
                        'rgba(255, 206, 86, 0.7)',
                        'rgba(75, 192, 192, 0.7)',
                        'rgba(153, 102, 255, 0.7)',
                        'rgba(255, 159, 64, 0.7)'
                    ],
                }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: true,
            aspectRatio: 1,
            layout: {
                padding: {
                    left: 10,
                    right: 10,
                    top: 10,
                    bottom: 10
                }
            }
        }
    });
} // FINALIZADO!!!
/*Iniciando as aplicacoes para o funcionamento do codigo*/
function iniciandoAplicacao() {
    if (!buttonExbicao) {
        console.error("Botão de exibição não encontrado!");
        return;
    }
    buttonExbicao.addEventListener('click', mundandoExibicao);
    buttonPessoa.addEventListener('click', mudandoPessoa);
    buttonGrafico.addEventListener('click', mudandoGrafico);
    const botaoCancelar = document.getElementById('cancelar');
    if (botaoCancelar) {
        botaoCancelar.addEventListener('click', () => {
            if (modoCriacao) {
                mundandoExibicao();
            }
        });
    }
}
if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', iniciandoAplicacao);
}
else {
    iniciandoAplicacao();
}
//# sourceMappingURL=main.js.map