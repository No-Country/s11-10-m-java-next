import axios from "axios"

export const getUser = async (setUserLog: Function) => {

    await axios.get(
        `https://reparame-api.onrender.com/me`, {
        headers: {
            Authorization: `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FAZ21haWwuY29tIiwiaWF0IjoxNjk4NjkyOTI0LCJleHAiOjE2OTg2OTQzNjR9.6ucRoFbvSlVXh1I7fM1FCWrA-EY6UkaTEPmGpjAa5VA`

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
