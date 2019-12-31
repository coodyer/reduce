using Reduce.handle;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Reduce.impl
{


    public abstract class AbstractImpl
    {
        HttpHandle http = new HttpHandle();

        internal HttpHandle Http
        {
            get { return http; }
            set { http = value; }
        }


    }
}
