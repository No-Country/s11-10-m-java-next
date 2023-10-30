import axios from "axios"

export const getUser = async (setUserLog: Function) => {

    await axios.get(
        `https://reparame-api.onrender.com/me`, {
        headers: {
            Authorization: `eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FAZ21haWwuY29tIiwiaWF0IjoxNjk4NjkwMjE5LCJleHAiOjE2OTg2OTE2NTl9.H3PGaWahr92WGF75PmjhS4p-nuXfDJXnZZYoMxybN64`

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
