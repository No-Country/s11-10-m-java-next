import axios from "axios"

export const postUser = async (data: any) => {
    try {
        const response = await axios.post(
            `https://reparame-api.onrender.com/user/registro`, {
            nombreCompleto: data.nombreCompleto,
            apellidoCompleto: data.apellidoCompleto,
            username: data.username,
            password: data.password,
            direccion: data.direccion,
            numeroTelefonico: data.numeroTelefonico,
            provincia: data.provincia,
            localidad: data.localidad,
            fechaNacimiento: data.fechaNacimiento,
            zona: data.zona,
            dni: data.dni,
            rol: data.rol
        }
        )
    return response.data
    } catch (error) {
        console.log(error)
        return error
    }

};
