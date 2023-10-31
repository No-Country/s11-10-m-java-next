import axios from "axios"

export const putUser = async (id: any, rol: any, formData: any,) => {
    const tok = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb3FhQGdtYWlsLmNvbSIsImlhdCI6MTY5ODc4MDI1OCwiZXhwIjoxNjk4NzgxNjk4fQ.HXemQyKyYQH84GPeBKusjxL93YRKBOCLOPT18p9NRpI'

    await axios.put(
        `https://reparame-api.onrender.com/${rol === 'prestador' ? 'prestadores' : 'clientes'}/${id}`, {
        formData
    }, {
        headers: {
            Authorization: `Bearer ${tok}`

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
