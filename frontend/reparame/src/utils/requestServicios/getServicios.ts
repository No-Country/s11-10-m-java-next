import axios from "axios"

export const getServicios = async (setPrestadores: Function, servicioId: any, token: string) => {

    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };

    await axios.get(
        `https://reparame-api.onrender.com/servicios`,config
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
