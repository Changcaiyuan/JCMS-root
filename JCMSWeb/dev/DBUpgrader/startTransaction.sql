﻿-- ==================================================================
-- startTransaction.sql
--
-- Created on July 21, 2009
--
-- ==================================================================
-- WARRANTY DISCLAIMER AND COPYRIGHT NOTICE
--
-- THE JACKSON LABORATORY MAKES NO REPRESENTATION ABOUT THE SUITABILITY OR
-- ACCURACY OF THIS SOFTWARE OR DATA FOR ANY PURPOSE, AND MAKES NO WARRANTIES,
-- EITHER EXPRESS OR IMPLIED, INCLUDING MERCHANTABILITY AND FITNESS FOR A
-- PARTICULAR PURPOSE OR THAT THE USE OF THIS SOFTWARE OR DATA WILL NOT
-- INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS, TRADEMARKS, OR OTHER RIGHTS.
-- THE SOFTWARE AND DATA ARE PROVIDED "AS IS".
--
-- This software and data are provided to enhance knowledge and encourage
-- progress in the scientific community and are to be used only for research
-- and educational purposes. Any reproduction or use for commercial purpose is
-- prohibited without the prior express written permission of
-- the Jackson Laboratory.
--
-- Copyright © 1996, 1999, 2000, 2007 by The Jackson Laboratory
-- All Rights Reserved
-- ==================================================================


-- ==================================================================
-- File name:       start.sql
-- Date developed:  July 21, 2009
-- Purpose:         Starts a MySQL database server transaction
-- Overview:
--     This script is always run first by the DBUpgrader tool to
--     start a MySQL transaction.  COMMIT and ROLLBACK implicitly
--     end the transaction.
-- Target DBMS : MySQL 5.1
-- Last changed by:   $Author:  $
-- Last changed date: $Date:  $
-- @author Craig Hanna
-- @version $Revision:  $
-- ==================================================================

START TRANSACTION;
