import axios from "axios"

export const putUser = async (id: any, rol: any, formData: any,) => {
    const tokenKey = localStorage.getItem('tKeyId')

    await axios.put(
        `https://reparame-api.onrender.com/${rol === 'prestador' ? 'prestadores' : 'clientes'}/${id}`, {
        formData
    }, {
        headers: {
            Authorization: `Bearer ${tokenKey}`

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
