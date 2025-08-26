import { Pessoa } from './pessoa';
export declare class Empresa implements Pessoa {
    id: number;
    nome: string;
    email: string;
    pais: string;
    estado: string;
    cep: string;
    descricao: string;
    competencias: string[];
    cnpj: string;
    constructor(id: number, nome: string, email: string, pais: string, cnpj: string, estado: string, cep: string, descricao: string, competencias: string[]);
}
//# sourceMappingURL=empresa.d.ts.map