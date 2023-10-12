import axios from "axios"


export const getServicios = async (setPrestadores) => {
    await axios.get(
        `https://jsonplaceholder.typicode.com/users`,
    )
        .then(function (response) {
            setPrestadores(response.data);
        })
        .catch(function (err) {
            console.log(err);

        })
};
