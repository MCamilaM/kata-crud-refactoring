import React, { Fragment } from 'react';
import StoreProvider from '../src/components/StoreProvider';
import FormList from './components/FormList';
import CreateList from "./components/CreateList"


function App() {

  return (
    <Fragment>

      <StoreProvider>

        <FormList/>
          <div className="row" id="columnaLista">
            <CreateList/>
          </div>
           

          
      </StoreProvider>
    </Fragment>
  );
}

export default App;
