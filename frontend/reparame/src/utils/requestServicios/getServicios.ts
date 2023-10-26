import axios from "axios"

export const getServicios = async (setPrestadores: Function, servicioId: any) => {

    await axios.get(
        `https://reparame-api.onrender.com/servicios${servicioId ? '/' + servicioId : ''}`, {
        headers: {
            Authorization: `eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FAZ21haWwuY29tIiwiaWF0IjoxNjk4Mjc2MDI2LCJleHAiOjE2OTgyNzc0NjZ9.ZvymjHsGB_cK4LdaL8nb6r1XGCzZeFVMd5A1Jb23Nbo`

        }
    }
    )
        .then(function (response) {
            setPrestadores(response.data)
        })
        .catch(function (err) {
            console.log(err);
        })
};
