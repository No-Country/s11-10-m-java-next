import axios from "axios"

export const postTicket = async (id: any, formData: any,) => {
    const tok = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FAZ21haWwuY29tIiwiaWF0IjoxNjk4NzY0OTMxLCJleHAiOjE2OTg3NjYzNzF9.5iVpTsMkVp0ZbAJgfEXXUImqzeX7p27IKMypKk6dPVY'

    await axios.post(
        `https://reparame-api.onrender.com/tickets/${id}`, {
        formData
    }, {
        headers: {
            Authorization: `Bearer ${tok}`

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
