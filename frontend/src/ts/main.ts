//import {Empresa} from './empresa';
//import Chart from "chart.js";
//import {Pessoa} from './pessoa';

let modoCriacao = false;
let modoPessoa = false;
let confirmacaoForm = false;

/*Configuração dos botões e elementos do HTML*/
const buttonExbicao = document.getElementById('buttonExibicao') as HTMLButtonElement || null;
const display = document.getElementById('displayContainer') as HTMLButtonElement || null;
const criacaoFormulario = document.getElementById('cricaoFormulario') as HTMLButtonElement || null;
const buttonPessoa = document.getElementById('buttonPessoa') as HTMLButtonElement || null;
const buttonGrafico = document.getElementById('buttonGrafico') as HTMLButtonElement || null;
const displayGrafico = document.getElementById('criacaoGrafico') as HTMLButtonElement || null;
const displayVagas = document.getElementById("vagas") as HTMLButtonElement || null;

/*Alterando os nome dos labels*/
const labelNomeEmpresa = document.getElementById('labelNomeEmpresa') as HTMLLabelElement || null;
const labelEmailEmpresa = document.getElementById('labelEmailEmpresa') as HTMLLabelElement || null;
const labelIdEmpresa = document.getElementById('labelIdEmpresa') as HTMLLabelElement || null;
const labelDescricaoEmpresa = document.getElementById('labelDescricaoEmpresa') as HTMLLabelElement || null;
const labelEstadoEmpresa = document.getElementById('labelEstadoEmpresa') as HTMLLabelElement || null;
const labelPaisEmpresa = document.getElementById('labelPaisEmpresa') as HTMLLabelElement || null;
const labelCepEmpresa = document.getElementById('labelCepEmpresa') as HTMLLabelElement || null;

/*Criando e salvando o form*/
const cadForm = document.getElementById('itemForm')  as HTMLFormElement || null;

document.addEventListener("DOMContentLoaded", (e) => {
    e.preventDefault();

    const nomePessoa = document.getElementById("nomeEmpresa") as HTMLInputElement;
    const emailPessoa = document.getElementById("emailEmpresa") as HTMLInputElement;
    const estadoEmpresa = document.getElementById("estadoEmpresa") as HTMLInputElement;
    const paisEmpresa = document.getElementById("paisEmpresa") as HTMLInputElement;
    const cepEmpresa = document.getElementById("cepEmpresa") as HTMLInputElement;

    let nomePessoaRegex = /^[a-zA-Z\s]+$/gi;
    let emailPessoaRegex = /[A-Za-z0-9\._-]+@[A-Za-z\.]+[A-Za-z]{2,3}/gi;
    let estadoEmpresaRegex = /^[a-zA-Z\s]+$/gi;
    let paisEmpresaRegex = /^[a-zA-Z\s]+$/gi;
    let cepEmpresaRegex = /^[0-9]{5}-[0-9]{3}$/gi;

    nomePessoa.addEventListener("input", (e) => {
        e.preventDefault();

        if(nomePessoa.value === ""){
            nomePessoa.style.borderColor = "";
        }

        if(nomePessoaRegex.test(nomePessoa.value.trim())){
            nomePessoa.style.borderColor = "green";
            confirmacaoForm = true;
        }else{
            nomePessoa.style.borderColor = "red";
            confirmacaoForm = false;
        }

    })

    emailPessoa.addEventListener("input", (e) => {
        e.preventDefault();

        if(emailPessoa.value === ""){
            emailPessoa.style.borderColor = "";
        }

        if(emailPessoaRegex.test(emailPessoa.value.trim())){
            emailPessoa.style.borderColor = "green";
            confirmacaoForm = true;
        }else{
            emailPessoa.style.borderColor = "red";
            confirmacaoForm = false;
        }
    })

    estadoEmpresa.addEventListener("input", (e) => {
        e.preventDefault();

        if(estadoEmpresa.value === ""){
            estadoEmpresa.style.borderColor = "";
        }

        if(estadoEmpresaRegex.test(estadoEmpresa.value.trim())){
            estadoEmpresa.style.borderColor = "green";
            confirmacaoForm = true;
        }else{
            estadoEmpresa.style.borderColor = "red";
            confirmacaoForm = false;
        }
    })

    paisEmpresa.addEventListener("input", (e) => {
        e.preventDefault();

        if(paisEmpresa.value === ""){
            paisEmpresa.style.borderColor = "";
        }

        if(paisEmpresaRegex.test(paisEmpresa.value.trim())){
            paisEmpresa.style.borderColor = "green";
            confirmacaoForm = true;
        }else{
            paisEmpresa.style.borderColor = "red";
            confirmacaoForm = false;
        }
    })

    cepEmpresa.addEventListener("input", (e) => {
        e.preventDefault();

        if(cepEmpresa.value === ""){
            cepEmpresa.style.borderColor = "";
        }

        if(cepEmpresaRegex.test(cepEmpresa.value.trim())){
            cepEmpresa.style.borderColor = "green";
            confirmacaoForm = true;
        }else{
            cepEmpresa.style.borderColor = "red";
            confirmacaoForm = false;
        }
    })
})


cadForm.addEventListener("submit", (e) =>{
    e.preventDefault();

    //Entradas do form
    const nomePessoa = document.getElementById("nomeEmpresa") as HTMLInputElement;
    const emailPessoa = document.getElementById("emailEmpresa") as HTMLInputElement;
    const idEmpresa = document.getElementById("idEmpresa") as HTMLInputElement;
    const descricaoEmpresa = document.getElementById("descricaoEmpresa") as HTMLInputElement;
    const estadoEmpresa = document.getElementById("estadoEmpresa") as HTMLInputElement;
    const competencias = document.querySelectorAll('input[type="checkbox"]');
    const paisEmpresa = document.getElementById("paisEmpresa") as HTMLInputElement;
    const cepEmpresa = document.getElementById("cepEmpresa") as HTMLInputElement;
    const nomeVaga = document.getElementById("nomeVaga") as HTMLInputElement;
    const descricaoVaga = document.getElementById("descricaoVaga") as HTMLInputElement;


    let values: string[] = [];

    competencias.forEach(checkbox => {
        if((checkbox as HTMLInputElement).checked){
            values.push((checkbox as HTMLInputElement).value);
        }
    })



    const nome = nomePessoa.value;
    const email = emailPessoa.value;
    const id = idEmpresa.value;
    const pais = paisEmpresa.value || "BRASIL";
    const cep = cepEmpresa.value;
    const descricao = descricaoEmpresa.value;
    const estado = estadoEmpresa.value;
    const checkCompetencias = values;
    const nameVaga = nomeVaga.value;
    const ddescriptionVaga = descricaoVaga.value;



    let empresas = [];
    let usuarios = [];
    let vagas = [];

    const tipo = modoPessoa ? "usuário" : "empresa";
    const adicionarEmpresaUsuario = document.getElementById("adicionarEmpresaUsuario");

    if(adicionarEmpresaUsuario){
        adicionarEmpresaUsuario.textContent = `Adicionar ${tipo}`;
    }

    if(confirmacaoForm){
        if(modoPessoa){
            //const empresa = new Empresa(nome, email, pais, id, estado, cep, descricao, checkCompetencias);
            if(localStorage.hasOwnProperty("usuarios")){
                usuarios = JSON.parse(localStorage.getItem("usuarios") || "[]");
            }else{
                usuarios = [];
            }
            if(!modoPessoa) return;
            usuarios.push({nome, email, id, descricao, estado, checkCompetencias, pais, cep});
            localStorage.setItem("usuarios", JSON.stringify(usuarios));
        }else{
            if(localStorage.hasOwnProperty("empresas")){
                empresas = JSON.parse(localStorage.getItem("empresas") || "[]");
                vagas = JSON.parse(localStorage.getItem("vagas") || "[]");
            }else{
                empresas = [];
                vagas = [];
            }
            if(modoPessoa) return;
            vagas.push({nameVaga, ddescriptionVaga});
            empresas.push({nome, email, id, descricao, vagas, estado, pais, cep});

            localStorage.setItem("empresas", JSON.stringify(empresas));
        }
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
})

/*Adicionando funcionalidade as classes {Empresa}/{Usuario}*/

function mudandoPessoa(){
    if(!buttonPessoa || !display || !criacaoFormulario){
        return;
    }
    modoPessoa = !modoPessoa;

    if(modoPessoa){
        buttonPessoa.textContent = 'Usuario'; //false
        labelNomeEmpresa.textContent = 'Nome do Usuario:';
        labelEmailEmpresa.textContent = 'Email do Usuario:';
        labelIdEmpresa.textContent = 'CPF do Usuario:';
        labelDescricaoEmpresa.textContent = 'Descricao do Usuario:';
        labelEstadoEmpresa.textContent = 'Estado do Usuario:';
        labelPaisEmpresa.textContent = 'Pais do Usuario:';
        labelCepEmpresa.textContent = 'CEP do Usuario:';
        displayVagas.style.display = 'none';
        carregarLista();
    }else{
        buttonPessoa.textContent = 'Empresa'; //true
        labelNomeEmpresa.textContent = 'Nome da Empresa:';
        labelEmailEmpresa.textContent = 'Email da Empresa:';
        labelIdEmpresa.textContent = 'CNPJ da Empresa:';
        labelDescricaoEmpresa.textContent = 'Descricao da Empresa:';
        labelEstadoEmpresa.textContent = 'Estado da Empresa:';
        labelPaisEmpresa.textContent = 'Pais da Empresa:';
        labelCepEmpresa.textContent = 'CEP da Empresa:';
        displayVagas.style.display = 'block';
        carregarLista();
    }

} // FINALIZADO!!

/*Alterando a exibicao de exibir para criar e criar para exibir*/
function mundandoExibicao(){
    if(!buttonExbicao || !display || !criacaoFormulario){
        return;
    }

    modoCriacao = !modoCriacao;

    if(modoCriacao){
        buttonExbicao.textContent = 'Exibir';
        display.style.display = 'none';
        criacaoFormulario.style.display = 'block';
        displayGrafico.style.display = 'none';


    }else{
        buttonExbicao.textContent = 'Criar';
        display.style.display = 'block';

        criacaoFormulario.style.display = 'none';
        displayGrafico.style.display = 'none';
        carregarLista()
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



        itens.forEach((item: any)=>{
            const novoItem = document.createElement("li");
            novoItem.className = "item";

            let itemMatch : string;
            if(efeitoMatch){ //Para testar o efeito de match é só colocar !efeitoMatch
                itemMatch = "***********";

            }else{
                itemMatch = item.nome;
            }
            novoItem.innerHTML = `<li>${tipo}: ${itemMatch}</br> Email: ${item.email}</br> ID: ${item.id}</br>Localização: ${item.estado}, ${item.pais}  CEP: ${item.cep}</br>Competencias: ${item.checkCompetencias}</br> Descrição: ${item.descricao}</li>`;

            listaElement.appendChild(novoItem);
        })
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
    if (display) display.style.display = 'none';
    if (criacaoFormulario) criacaoFormulario.style.display = 'none';

    // Agora busca o canvas
    const canvas = document.getElementById('grafico') as HTMLCanvasElement | null;
    if (!canvas) {
        console.error('Elemento canvas não encontrado!');
        return;
    }

    // Verifica se o Chart está disponível
    if (typeof Chart === 'undefined') {
        console.error('Chart.js não foi carregado corretamente!');
        return;
    }

    const competenciaUsuario = usuarios.flatMap((usuario: { checkCompetencias: Set<string> | string[] }) =>
        Array.from(usuario.checkCompetencias));
    const contagemCompetencias = competenciaUsuario.reduce((acc: Record<string, number>, competencia: string) => {
        acc[competencia] = (acc[competencia] || 0) + 1;
        return acc;
    }, {} as Record<string, number>);

    const labels = Object.keys(contagemCompetencias);
    const dados = Object.values(contagemCompetencias);
    
    // Cria o gráfico
    return new Chart(canvas, {
        type: 'polarArea',
        data: {
            labels: labels,
            datasets: [{
                label: 'Usuários',
                data: dados as (number | number[] | null | undefined)[],
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
            layout:{
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
} else {
    iniciandoAplicacao();
}