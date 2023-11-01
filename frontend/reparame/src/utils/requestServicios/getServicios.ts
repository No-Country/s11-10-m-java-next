import axios from "axios"

export const getServicios = async (setPrestadores: Function, servicioId: any, token: string) => {
    const tokenKey = localStorage.getItem('tKeyId')
    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };

    await axios.get(
        `https://reparame-api.onrender.com/servicios${servicioId ? '/' + servicioId : ''}`,config
    )
        .then(function (response) {
            console.log(token)
            console.log(response.data)
            setPrestadores(response.data)
        })
        .catch(function (err) {
            console.log('error')
            console.log(err);
        })

};
