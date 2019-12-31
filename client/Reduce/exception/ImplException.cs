using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace Reduce.exception
{
   public class ImplException : ApplicationException
    {
        private string error;
        private Exception innerException;
        //无参数构造函数
        public ImplException()
        {

        }
        //带一个字符串参数的构造函数，作用：当程序员用Exception类获取异常信息而非 MyException时把自定义异常信息传递过去
        public ImplException(string msg) : base(msg)
        {
            this.error = msg;
        }
        //带有一个字符串参数和一个内部异常信息参数的构造函数
        public ImplException(string msg, Exception innerException) : base(msg)
        {
            this.innerException = innerException;
            this.error = msg;
        }
        public string GetError()
        {
            return error;
        }
    }
}
