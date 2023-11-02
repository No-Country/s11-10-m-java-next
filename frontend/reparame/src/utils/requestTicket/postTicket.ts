import axios from "axios"

export const postTicket = async (id: any, token: any) => {
    let f = new Date();
    let dia = f.getDate();
    let mes = f.getMonth();
    let anio = f.getFullYear();
    await axios.post(
        `https://reparame-api.onrender.com/tickets/${id}`, {
        descripcion: "Ticket de contratacion",
        fechaInicio: `${anio}-${mes}-${dia < 10 ? '0' + dia : dia}`,
        fechaRequerida: `${anio}-${mes}-${dia < 10 ? '0' + (dia + 5) : dia + 5}`
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
