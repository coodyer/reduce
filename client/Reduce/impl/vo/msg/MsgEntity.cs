using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Reduce.impl.vo.msg
{
    class MsgEntity<T>
    {
        private int code;

        public int Code
        {
            get { return code; }
            set { code = value; }
        }
        private String msg;

        public String Msg
        {
            get { return msg; }
            set { msg = value; }
        }
        private T datas;

        public T Datas
        {
            get { return datas; }
            set { datas = value; }
        }

  
    }
}
