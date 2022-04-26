/*
 * Copyright (C) 2020 pierpaolo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package di.uniba.map.b.lab.eccezioni;

/**
 *
 * @author pierpaolo
 */
public class MailParser {

    /**
     *
     */
    public static final String MAIL_REGEXP = "[A-Za-z]\\w+(\\.\\w+)?@[A-Za-z]\\w+\\.[a-zA-Z]{2,3}";

    /**
     *
     * @param mailAddress
     * @throws EmailException
     */
    public static void checkMail(String mailAddress) throws EmailException {

        boolean check = mailAddress.matches(MAIL_REGEXP);
        if (!check) {
            throw new EmailException();
        }
    }
}
