using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Reduce.impl.vo
{
    class UserCreateReqVO
    {
        private String email;

        public String Email
        {
            get { return email; }
            set { email = value; }
        }

        private String password;

        public String Password
        {
            get { return password; }
            set { password = value; }
        }

        private String code;

        public String Code
        {
            get { return code; }
            set { code = value; }
        }

 
    }
}
