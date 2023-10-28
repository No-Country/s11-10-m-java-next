'use client'
import { setLog } from "@/utils/globalStates/features/pathSlice"
import { useAppDispatch } from "@/utils/globalStates/hooks"
import { useEffect } from "react"

const HeaderManager = (page: any) => {
    const dispatch = useAppDispatch()
    useEffect(() => {
        dispatch(setLog(page.page))
    }, [dispatch, page])
    return (
        null
    )
}

export default HeaderManager