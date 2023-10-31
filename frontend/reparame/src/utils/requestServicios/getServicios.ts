import axios from "axios"

export const getServicios = async (setPrestadores: Function, servicioId: any, token: string) => {
    const tokenKey = localStorage.getItem('tKeyId')
    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };

    await axios.get(
        `https://reparame-api.onrender.com/servicios${servicioId ? '/' + servicioId : ''}`, {
        headers: {
            Authorization: `Bearer ${tokenKey}`
        }
    }
    )
        .then(function (response) {
            setPrestadores(response.data)
            console.log(response.data)
            console.log('la data entro')
        })
        .catch(function (err) {
            console.log('ocurrio un error')
            console.log(err);
        })
};
