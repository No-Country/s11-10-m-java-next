import axios from "axios"
// "username": "joqa@gmail.com",
//         "password": "Ae12345+"
export const postLogin = async (userData: any) => {
    await axios.post(
        `https://reparame-api.onrender.com/user/login`, userData
    )
        .then(function (response: any) {
            localStorage.setItem('tKeyId', response.data.body.token);
        })
        .catch(function (err) {
            console.log(err);
        })
};