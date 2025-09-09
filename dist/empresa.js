export class Empresa {
    constructor(nome, email, pais, cnpj, estado, cep, descricao, vagas) {
        this._id = Empresa.proximoId++;
        this._nome = nome;
        this._email = email;
        this._pais = pais;
        this._cnpj = cnpj;
        this._estado = estado;
        this._cep = cep;
        this._descricao = descricao;
        this._vagas = vagas;
    }
    get id() {
        return this._id;
    }
    set id(value) {
        this._id = value;
    }
    get nome() {
        return this._nome;
    }
    set nome(value) {
        this._nome = value;
    }
    get email() {
        return this._email;
    }
    set email(value) {
        this._email = value;
    }
    get pais() {
        return this._pais;
    }
    set pais(value) {
        this._pais = value;
    }
    get estado() {
        return this._estado;
    }
    set estado(value) {
        this._estado = value;
    }
    get cep() {
        return this._cep;
    }
    set cep(value) {
        this._cep = value;
    }
    get descricao() {
        return this._descricao;
    }
    set descricao(value) {
        this._descricao = value;
    }
    get competencias() {
        return this._vagas;
    }
    set competencias(value) {
        this._vagas = value;
    }
    get cnpj() {
        return this._cnpj;
    }
    set cnpj(value) {
        this._cnpj = value;
    }
}
Empresa.proximoId = 1;
//# sourceMappingURL=empresa.js.map