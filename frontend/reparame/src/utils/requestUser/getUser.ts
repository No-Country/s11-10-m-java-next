import axios from "axios"

export const getUser = async (setUserLog: Function) => {
    const tokenKey = localStorage.getItem('tKeyId')
    await axios.get(
        `https://reparame-api.onrender.com/user/me`, {
        headers: {
            Authorization: `Bearer ${tokenKey}`

        }
    }
    )
        .then(function (response) {
            console.log(response)
            setUserLog(response.data)
        })
        .catch(function (err) {
            console.log(err);
        })
};
