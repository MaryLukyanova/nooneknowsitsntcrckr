package command.client;

import command.*;

public enum CommandEnum {
   ADDSTONE {
       {
           this.command = new AddStoneCommand();
       }
    },

    SORTBYCARAT {
        {
            this.command = new SortByCaratCommand();
        }
    },

    SORTBYPRICE {
        {
            this.command = new SortByCaratPriceCommand();
        }
    },
    GETNECKLCARAT {
        {
            this.command = new CaratSumCommand();
        }
    },
    GETNECKLPRICE {
        {
            this.command = new PriceSumCommand();
        }
    },
    FINDSTONESINRANGE {
        {
            this.command = new StonesInRangeCommand();
        }
    };

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}