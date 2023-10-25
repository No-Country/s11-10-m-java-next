import axios from "axios"

export const getServicios = async (setPrestadores: Function, servicioId: any) => {

    await axios.get(
        `https://reparame-api.onrender.com/servicios${servicioId ? '/' + servicioId : ''}`,
    )
        .then(function (response) {
            setPrestadores(response.data)
        })
        .catch(function (err) {
            console.log(err);
        })
};
