import axios from "axios"

export const getServicios = async (setPrestadores: Function, servicioId: any, token: string) => {

    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };

    await axios.get(
        `https://reparame-api.onrender.com/servicios${servicioId ? '/' + servicioId : ''}`, {
        headers: {
            Authorization: `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FAZ21haWwuY29tIiwiaWF0IjoxNjk4Njk0NTU3LCJleHAiOjE2OTg2OTU5OTd9.PDBGtrygXfywq0Dhn0UdfuNVwRL4F61wuHQwAtP3L2o`
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
