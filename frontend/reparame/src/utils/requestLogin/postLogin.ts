import axios from "axios"

export const postLogin = async () => {
    await axios.post(
        `https://reparame-api.onrender.com/user/login`, {
        "username": "joqa@gmail.com",
        "password": "Ae12345+"
    }
    )
        .then(function (response: any) {
            console.log(response.data.body.token);

            localStorage.setItem('tKeyId', response.data.body.token);

        })
        .catch(function (err) {
            console.log(err);
        })
};