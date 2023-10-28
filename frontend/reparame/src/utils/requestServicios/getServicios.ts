import axios from "axios"

export const getServicios = async (setPrestadores: Function, servicioId: any) => {

    await axios.get(
        `https://reparame-api.onrender.com/servicio/${servicioId ? 'buscarPorID/' + servicioId : 'listar'}`,
    )
        .then(function (response) {
            setPrestadores(response.data)
        })
        .catch(function (err) {
            console.log(err);
        })
};
