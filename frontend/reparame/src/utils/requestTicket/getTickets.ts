import axios from "axios";

export const getTickets = async (setTickets: Function, token: any) => {
  const tokenKey = localStorage.getItem('tKeyId')
  await axios
    .get(`https://reparame-api.onrender.com/tickets`, {
      headers: {
        Authorization: `Bearer ${token}`

      }
    })

    .then(function (response) {
      console.log(response);
      setTickets(response.data);
    })
    .catch(function (err) {
      console.log(err);
    });
};
