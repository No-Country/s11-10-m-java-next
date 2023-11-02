import axios from "axios";

export const getServicios = async (setPrestadores: Function, servicioId: any, token: string, category: any) => {
    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };

    await axios.get(
        `https://reparame-api.onrender.com/servicios${servicioId ? '/' + servicioId : `?categoria=${category}`}`, {
        headers: { Authorization: `Bearer ${token}` }
    }
    )
        .then(function (response) {
            console.log(token);

            setPrestadores(response.data);
        })
        .catch(function (err) {
            localStorage.setItem("key", token);
            console.log("error");
            console.log(err);
        });
};
