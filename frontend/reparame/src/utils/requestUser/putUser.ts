import axios from "axios"

export const putUser = async (id: any, rol: any, formData: any, token: any) => {
    const tokenKey = localStorage.getItem('tKeyId')

    await axios.put(
        `https://reparame-api.onrender.com/${rol === 'prestador' ? 'prestadores' : 'clientes'}/${id}`, {
        formData
    }, {
        headers: {
            Authorization: `Bearer ${token}`

        }
    }
    )
        .then(function (response) {
            console.log(response);

        })
        .catch(function (err) {
            console.log(err);
        })
};
