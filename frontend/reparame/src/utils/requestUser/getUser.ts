import axios from "axios"

export const getUser = async (setUserLog: Function) => {

    await axios.get(
        `https://reparame-api.onrender.com/prestadores`,
    )
        .then(function (response) {
            console.log(response)
            setUserLog(response.data)
        })
        .catch(function (err) {
            console.log(err);
        })
};
