export interface LenderType {
    id: number,
    nombreCompleto: string,
    username: string,
    password: string,
    direccion: string,
    numeroTelefonico: string,
    provincia: string,
    localidad: string,
    fechaNacimiento: string,
    alta: boolean,
    rol: string,
    zona: string,
    servicios: ServiceType[],
    clasificaciones: [],
    dni: string
}

export interface ServiceType {
    id_Servicio: number,
    descripcion: string,
    añosSector: number,
    precio: number,
    alta: boolean,
    rubro: string,
    tickets: TicketType[],
    prestador: null
}

export interface TicketType {
    id: number,
    estado: boolean,
    description: string,
    fechaInicio: string,
    fechaRequerida: string
}