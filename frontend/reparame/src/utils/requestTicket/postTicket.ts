import axios from "axios"

export const postTicket = async (id: any, formData: any, token: any) => {
    await axios.post(
        `https://reparame-api.onrender.com/tickets/${id}`, {
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
