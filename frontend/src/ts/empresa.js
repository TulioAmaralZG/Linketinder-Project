"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Empresa = void 0;
var Empresa = /** @class */ (function () {
    function Empresa(id, nome, email, pais, cnpj, estado, cep, descricao, competencias) {
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
    return Empresa;
}());
exports.Empresa = Empresa;
