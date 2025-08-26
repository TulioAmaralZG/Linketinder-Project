import {Pessoa} from './pessoa'

export class Empresa implements Pessoa{
    private static proximoId = 1;
    private _id: number;
    private _nome: string; //tem
    private _email: string; // tem
    private _pais: string; // tem
    private _estado: string; //tem
    private _cep: string; //nao
    private _descricao: string; //tem
    private _competencias: string[]; //tem
    private _cnpj: string; //tem

    constructor(
    nome: string,
    email: string,
    pais: string,
    cnpj: string,
    estado: string,
    cep: string,
    descricao: string,
    competencias: string[]) {
        this._id = Empresa.proximoId++;
        this._nome = nome;
        this._email = email;
        this._pais = pais;
        this._cnpj = cnpj;
        this._estado = estado;
        this._cep = cep;
        this._descricao = descricao;
        this._competencias = competencias;
    }

    get id(): number {


        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get nome(): string {
        return this._nome;
    }

    set nome(value: string) {
        this._nome = value;
    }

    get email(): string {
        return this._email;
    }

    set email(value: string) {
        this._email = value;
    }

    get pais(): string {
        return this._pais;
    }

    set pais(value: string) {
        this._pais = value;
    }

    get estado(): string {
        return this._estado;
    }

    set estado(value: string) {
        this._estado = value;
    }

    get cep(): string {
        return this._cep;
    }

    set cep(value: string) {
        this._cep = value;
    }

    get descricao(): string {
        return this._descricao;
    }

    set descricao(value: string) {
        this._descricao = value;
    }

    get competencias(): string[] {
        return this._competencias;
    }

    set competencias(value: string[]) {
        this._competencias = value;
    }

    get cnpj(): string {
        return this._cnpj;
    }

    set cnpj(value: string) {
        this._cnpj = value;
    }
}