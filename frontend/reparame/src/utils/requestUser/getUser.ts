import axios from "axios"

export const getUser = async (setUserLog: Function, token: any) => {
    await axios.get(
        `https://reparame-api.onrender.com/user/me`, {
        headers: {
            Authorization: `Bearer ${token}`

        }
    }
    )
        .then(function (response) {
            setUserLog(response.data)
        })
        .catch(function (err) {
            console.log(err);
        })
};
