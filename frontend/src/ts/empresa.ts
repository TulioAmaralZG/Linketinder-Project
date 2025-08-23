import {Pessoa} from './pessoa'

class Empresa implements Pessoa{
    id: number;
    nome: string;
    email: string;
    pais: string;
    estado: string;
    cep: string;
    descricao: string;
    competencias: string[];
    cnpj: string;

    constructor(id: number,
    nome: string,
    email: string,
    pais: string,
    cnpj: string,
    estado: string,
    cep: string,
    descricao: string,
    competencias: string[]) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.pais = pais;
        this.cnpj = cnpj;
        this.estado = estado;
        this.cep = cep;
        this.descricao = descricao;
        this.competencias = competencias;
    }



}