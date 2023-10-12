import React from 'react'
const SearchBar = () => {
  return (
    <form className='flex min-w-searchBar flex-row max-w-2xl w-full rounded'>
      <input type="text" name="" id="" placeholder='Búsqueda'
        className='w-full h-8 rounded-md pl-2 min-w-150p outline-none' />
      <input type="submit" value="Q" className='relative right-6 cursor-pointer	pl-1 border-black border-l-2' />
    </form>
  )
}

export default SearchBar